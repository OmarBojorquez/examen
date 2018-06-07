# examen
Repo para el examen Calculadora 7 Jun

Este proyecto funciona como una calculadora básica

Para probar su funcionamiento se sugiere acudir al DockerHub correspondiente
y seguir las instrucciones: https://hub.docker.com/r/omarbojorquez/calcu/


Instrucciones para crear y correr el servidor VertX desde el docker
1.- Bajar el docker: docker pull omarbojorquez/calcu

2.- Ejecutarlo tantas veces como se desee, cada comando crea un contenedor Docker y una instancia de VertX: 
docker run -it -p 808X:8080 -e PBA="HolaMundoX" omarbojorquez/calcu java -jar sample-1.0-SNAPSHOT-fat.jar

(donde la X son los 6 puertos distintos donde se va a desplegar los servicios. ej: 8081,8082,8083,8084,8085,8086
si se desea balancear con HAProxy en el archivo de configuración (/etc/haproxy/haproxy.cfg) -backend- se pone:
backend site-backend
    mode http
    stats enable
    stats uri /haproxy?stats
    balance roundrobin
    server lamp1 localhost:8081 check
    server lamp2 localhost:8082 check
    server lamp3 localhost:8083 check
    server lamp4 localhost:8084 check
    server lamp5 localhost:8085 check
    server lamp6 localhost:8086 check)

Probarlo en: http://localhost:XXXX/api/suma?num1=Y&num2=Z
http://localhost:XXXX/api/resta?num1=Y&num2=Z
http://localhost:XXXX/api/multiplicacion?num1=Y&num2=Z
http://localhost:XXXX/api/division?num1=Y&num2=Z
(donde las XXXX es el numero de puerto del frontend del HAProxy,
Y y Z son los numeros de la operación seleccionada
Ejemplo de un frontend en el archivo de configuracion /etc/haproxy/haproxy.cfg:
frontend www
    bind localhost:9090
    default_backend site-backend

NOTA: El frontend debe ir antes del backend)

