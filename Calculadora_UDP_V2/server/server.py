import socket
import random
import treatMessage

HOST = "127.0.0.1"
PORT = 6789
udpServer = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
orig = (HOST, PORT)
udpServer.bind(orig)
contador = 0

try:
    while True:
        rand = random.randint(0, 10)
        data, clientAddress = udpServer.recvfrom(1024)
        data = data.decode('utf-8')
        if data == "exit":
            udpServer.sendto(data.encode('utf-8'), clientAddress)
        response = treatMessage.calcular(data)
        
        # symbolize a delay in response
        if rand < 4:
            continue
        # default response is "<value>"
        udpServer.sendto(str(response).encode('utf-8'), clientAddress)
        contador = contador + 1
except KeyboardInterrupt:
    print("\nI worked in " + str(contador) + " operations for now. Bye...")

udpServer.close()
