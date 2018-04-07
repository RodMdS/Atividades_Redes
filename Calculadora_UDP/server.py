import socket
HOST = "127.0.0.1"
PORT = 6789
udpServer = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
orig = (HOST, PORT)
udpServer.bind(orig)

def div(op1, op2):
    if float(op2) == 0:
        return "Error: Division by zero"
    return float(op1) / float(op2) 

def calcular(msg):
    # default message is "<metodo> <op1> <op2>"
    caracteres = msg.split(" ")
    if caracteres[0] == "add":
        resp = float(caracteres[1]) + float(caracteres[2])
        pass
    elif caracteres[0] == "sub":
        resp = float(caracteres[1]) - float(caracteres[2])
        pass
    elif caracteres[0] == "mpy":
        resp = float(caracteres[1]) * float(caracteres[2])
        pass
    elif caracteres[0] == "div":
        resp = div(float(caracteres[1]), float(caracteres[2]))
        pass
    else:
        resp = "Error: the message isn't correct"
        pass
    return resp

while True:
    data, clientAddress = udpServer.recvfrom(1024)
    data = data.decode('utf-8')
    if data == "exit":
        udpServer.sendto(data.encode('utf-8'), clientAddress)
    resultado = calcular(data)
    udpServer.sendto(str(resultado).encode('utf-8'), clientAddress)
udpServer.close()
