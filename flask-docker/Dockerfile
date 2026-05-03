FROM python:3.12-alpine

WORKDIR /usr/src/app

COPY ./flaskApp/requirements.txt ./flaskApp/requirements.txt

RUN pip install -r ./flaskApp/requirements.txt

COPY . .

VOLUME /db-volume

EXPOSE 8080

CMD ["python", "./flaskApp/app.py"]