# Flask Application Project

This repository of a Flask application is part of project for the DevOps course of [DEVOPS Experts](https://devopsexperts.co.il/) developer.

Instructor: [Nuni Doron](https://github.com/nunidoron)


## Docker

First part of the project is about building a docker of web application with flask.


## Helm - Kubernetes

Second part of the project is about building flask package using kubernetes and helm.

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
