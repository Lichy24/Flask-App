# Webapp Orchestration

This repository of a Flask docker application is part of project for the DevOps course of [DEVOPS Experts](https://devopsexperts.co.il/) developer.

Instructor: [Nuni Doron](https://github.com/nunidoron)


## Helm Setup

This section shows how to build your yaml files and run a the system. 

Note: Windows and Linux commands of the helm are the same.

### Edit values.yaml

The values.yaml file contains all the dynamic values.
Which can be change such that can be made for better setting of the system.

For example the number of replicaCount:

`values.yaml`
'''
replicaCount = 3
'''

### Helm Template

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

### Helm Install

Install the package(recommand setting up your own user and password for the database):

```bash
    $ helm install flask-package . --set secert.data.mongodb-username="admin" --set secert.data.mongodb-password="pss321"
```
Flags:

--set : overwrite a value of key in the values.yaml file

### Helm Test

```bash
    $ helm test flask-package --logs
```

Flags:
--logs : outputs the test results

### Helm Uninstall

Uninstall the package:

```bash
    $ helm uninstall flask-package
```

##  Directory Structure

```
└── flask-package/                          # helm package directory
    ├── charts/                         # helm charts
    ├── crds/                           # helm crds
    ├── templates/                      # contains the different kubernetes services
    │   ├── configmap.yaml              # kubernetes configmap
    │   ├── cronjob.yaml                # kubernetes cronjob
    │   ├── dbservice.yaml              # kubernetes service for database
    │   ├── dbstatefulset.yaml          # kubernetes statefulset hold database 
    │   ├── deployment.yaml             # kubernetes deployment
    │   ├── hpa.yaml                    # kubernetes horizontal pod autoscaling (hpa)
    │   ├── NOTES.txt                   # text note on install of package
    │   ├── persistentvolume.yaml       # kubernetes persistent volume
    │   ├── persistentvolumeclaim.yaml  # kubernetes persistent volume claim   
    │   ├── secret.yaml                 # kubernetes secert  
    │   ├── service.yaml                # kubernetes service for flask  
    │   └── serviceaccount.yaml         # kubernetes service account
    ├── Chart.yaml                      # helm Chart
    ├── README.md                       # description and instruions of Flask-Orchestration
    ├── values.schema.json              # helm values schema
    └── values.yaml                     # helm values
```
