# Flask Pipeline

This repository of a Flask pipeline is part of project for the DevOps course of [DEVOPS Experts](https://devopsexperts.co.il/) developer.

Instructor: [Nuni Doron](https://github.com/nunidoron)


## Jenkins Setup

This section shows how to setup your jenkins and run the pipeline.

### installing systems

For the pipeline the following softwares are needed:
* miniKube
* Helm
* Docker
* Terraform (optional)
* AWS CLI (optional)

### Install & Setup of Jenkins

you need to install [jenkins](https://www.jenkins.io/) and run it on a different port from the default cause of conflication with the flask-app:

```bash
    $ java -jar jenkins.war --httpPort=9090
```

NOTE: you can also use JDK instead of your local installed JAVA.

Flags:
- httpPort : overwrite the default port to connect to the http page of jenkins.

### Create & Build Pipeline

create jenkins pipeline and copy past the content of the groovy file into the jenkins configurations of pipeline.


##  Directory Structure

```
└── flask-jenkins/                      # jenkins directory
    ├── jenkins/                        # contains the pipeline configuration files
    │   ├── main.tf                     # TBA
    │   └── pipeline.groovy             # groovy pipeline script
    └──  README.md                      # description and instruions of flask jenkins
```
