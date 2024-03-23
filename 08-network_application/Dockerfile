# Utilizamos una imagen base de Java
FROM openjdk:11

# Copiamos el archivo fuente Java al contenedor
COPY NetworkInfo.java /usr/src/app/

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /usr/src/app/

# Compilamos el programa Java
RUN javac NetworkInfo.java

# Ejecutamos el programa Java
CMD ["java", "NetworkInfo"]
