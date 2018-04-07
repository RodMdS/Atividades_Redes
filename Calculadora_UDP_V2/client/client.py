import socket

HOST = "127.0.0.1"
PORT = 6789
udpClient = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
dest = (HOST, PORT)

print("Type exit to quit")
request = ""
while request != "exit":
    try:
        request = raw_input("Type your request: ")
        # default request is "<method> <op1> <op2>"
        udpClient.sendto(request.encode('utf-8'), dest)
        udpClient.settimeout(1.5)
        response, cliente = udpClient.recvfrom(1024)
        response = response.decode('utf-8')
        if response != "exit":
            print(response)
    except socket.timeout:
        print("Error: timeout expired...\n")
        cont = 9
        while cont > 0:
            if cont == 1:
                print("Error: server currently unavailable, please try again later.\n")
                request = "exit"
                break
            else:
                try:
                    udpClient.sendto(request.encode('utf-8'), dest)
                    udpClient.settimeout(1.5)
                    response, cliente = udpClient.recvfrom(1024)
                    response = response.decode('utf-8')
                    if response != "exit":
                        print(response)
                    break
                except socket.timeout:
                    print("Error: timeout expired...\n")
                    cont = cont - 1

print("Connection closed...")
