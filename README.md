# Flask Application Project

This repository of a Flask application is part of project for the DevOps course of [DEVOPS Experts](https://devopsexperts.co.il/) developer.

Instructor: [Nuni Doron](https://github.com/nunidoron)


## Docker

![Docker Badge](https://img.shields.io/docker/v/lichy24/flask-app)
![Docker Downloads](https://img.shields.io/docker/pulls/lichy24/flask-app)

First part of the project is about building a docker of web application with flask.

### Setup Docker

This section shows how to build your image and run a container for that image. 

Note: Windows and Linux commands of the docker are the same.

#### How to build docker image

Building the image of the Flask application as follow:

```bash
    $ docker build -t flask-app:1.1 .
```
Flags:
- t : the tag name of the image

#### How to build container image

Building the container for the image to run as follow:

```bash
    $ docker run -p 8080:8080 -d --name FlaskApp flask-app:1.1
```
Flags:
- p : port connecting, the 8080 port of host with the expose port of 8080 of the container

- d : detaching the container from the current terminal hence running daemon.
--name: the name of the container

Note: if change the name/version of the container image update the "flaskapp:1.0". Also you can give different name to container as you please instead of the "FlaskApp" but don't forget you changed it.

#### How to compose the docker

```bash
    $ docker compose up -d 
```

Flags:
- d : detaching the container from the current terminal hence running daemon.



## Helm - Kubernetes

Second part of the project is about building flask package using kubernetes and helm.

### Basic Struction

The default build will create a Deployment with HPA of the application and database deployoment with hourly updates to the database.

Below you can see and learn how to edit and change the basic struction of the package system created.

### Helm Setup

This section shows how to build your yaml files and run the system.

Note: Windows and Linux commands of the helm are the same.

#### Edit values.yaml

The values.yaml file contains all the dynamic values.
Which can be change such that can be made for better setting of the system.

For example the number of replicaCount:

`values.yaml`
```bash
    replicaCount = 3
```

#### Helm Template

You can see the yaml files via template command as follow:

```bash
    $ helm template .
```
you can overwrite the values.yaml with another yaml as followed:

```bash
    $ helm template . -f test-values.yaml
```
Flags:
- f : overwrite the overlapping keys with the give yaml file

#### Helm Install

Install the package(recommand setting up your own user and password for the database):

```bash
    $ helm install flask-package . --set secert.data.mongodb-username="admin" --set secert.data.mongodb-password="pss321"
```
Flags:

--set : overwrite a value of key in the values.yaml file

#### Helm Test

```bash
    $ helm test flask-package --logs
```

Flags:
--logs : outputs the test results

#### Helm Uninstall

Uninstall the package:

```bash
    $ helm uninstall flask-package
```

##  Directory Structure

```
└── Flask-App/                              # project's root directory.
    ├─flask-docker/                      
    │   ├── flaskApp/                       # contains the flask application
    │   │   ├──  assets/                    # contains images and files for the html
    │   │   ├──  templates/                 # contains the html files
    │   │   ├──  app.py                     # main to run the flask app
    │   │   └──  requirements.txt           # app requirements
    │   ├── docker-compose.yml              # docker compose file to combine the flask app with other functions
    │   ├── README.md                       # description and instruions of flask-App
    │   └── Dockerfile                      # builds app into a working docker
    ├── flask-package/                      # helm package directory
    │   ├── charts/                         # helm charts
    │   ├── crds/                           # helm crds
    │   ├── templates/                      # contains the different kubernetes services
    │   │   ├── configmap.yaml              # kubernetes configmap
    │   │   ├── cronjob.yaml                # kubernetes cronjob
    │   │   ├── dbservice.yaml              # kubernetes service for database
    │   │   ├── dbstatefulset.yaml          # kubernetes statefulset hold database 
    │   │   ├── deployment.yaml             # kubernetes deployment
    │   │   ├── hpa.yaml                    # kubernetes horizontal pod autoscaling (hpa)
    │   │   ├── NOTES.txt                   # text note on install of package
    │   │   ├── persistentvolume.yaml       # kubernetes persistent volume
    │   │   ├── persistentvolumeclaim.yaml  # kubernetes persistent volume claim   
    │   │   ├── secret.yaml                 # kubernetes secert  
    │   │   ├── service.yaml                # kubernetes service for flask  
    │   │   └── serviceaccount.yaml         # kubernetes service account
    │   ├── Chart.yaml                      # helm Chart
    │   ├── README.md                       # description and instruions of Flask-Orchestration
    │   ├── values.schema.json              # helm values schema
    │   └── values.yaml                     # helm values
    └── README.md                           # description and instruions of the project
```
