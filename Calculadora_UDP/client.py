import socket
HOST = "127.0.0.1"
PORT = 6789
udpClient = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
dest = (HOST, PORT)
print("Type exit to quit")
request = ""
while request != "exit":
    request = input("Type your request: ")
    udpClient.sendto(request.encode('utf-8'), dest)
    response, cliente = udpClient.recvfrom(1024)
    response = response.decode('utf-8')
    if response != "exit":
        print(response)
udpClient.close()
print("Connection closed...")
