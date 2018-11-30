import socket
import ControllerServer as controller

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_address = ('127.0.0.1', 9876)
sock.bind(server_address)
sock.listen(1)

while True:
	print('Aguardando conexão...')
	connection, client_adrress = sock.accept()
	try:
		test = True
		while test:
			request = connection.recv(1024).decode(encoding='UTF-8')
			if request == "exit":
				test = False
			else:
				response = controller.defineOperation(request)
				connection.send(bytes(response + "\r\n", 'UTF-8'))
	finally:
		connection.close()
