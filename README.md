# Flask App Docker

This repository of a Flask docker application is part of project for the DevOps course of [DEVOPS Experts](https://devopsexperts.co.il/) developer.

Instructor: [Nuni Doron](https://github.com/nunidoron)


## Setup Docker

This section shows how to build your image and run a container for that image. 

Note: Windows and Linux commands of the docker are the same.

### How to build docker image

Building the image of the Flask application as follow:

```bash
    $ docker build -t flask-app:1.0 .
```
Flags:
- t : the tag name of the image

### How to build container image

Building the container for the image to run as follow:

```bash
    $ docker run -p 5000:5000 -d --name FlaskApp flask-app:1.0
```
Flags:
- p : port connecting, the 5000 port of host with the expose port of 5000 of the container

- d : detaching the container from the current terminal hence running daemon.
--name: the name of the container

Note: if change the name/version of the container image update the "flaskapp:1.0". Also you can give different name to container as you please instead of the "FlaskApp" but don't forget you changed it.

### How to compose the docker

```bash
    $ docker -d compose up
```

Flags:
- d : detaching the container from the current terminal hence running daemon.

##  Directory Structure

```
└── project_part1/                   # Project's root directory.
    ├── flaskApp/                    # contains the flask application
    │   ├──  assets/                 # contains images and files for the html
    │   ├──  templates/              # contains the html files
    │   ├──  app.py                  # main to run the flask app
    │   └──  requirements.txt        # app requirements
    ├── docker-compose.yml           # docker compose file to combine the flask app with other functions   
    └── Dockerfile                   # builds app into a working docker
```
