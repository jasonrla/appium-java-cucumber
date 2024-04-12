#!/bin/bash

# Función para verificar si un puerto está en uso
port_in_use() {
  nc -z localhost $1 </dev/null >/dev/null 2>&1
}

# Puerto base
port=4723

# Bucle para encontrar un puerto libre
while port_in_use $port; do
  ((port++))
done

# Imprime el puerto encontrado
echo $port
