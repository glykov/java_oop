from socket import *

my_host = ""
my_port = 8189

sockobj = socket(AF_INET, SOCK_STREAM)
sockobj.bind((my_host, my_port))
sockobj.listen(5)

while (True):
    connection, address = sockobj.accept()
    print('Server connected by', address)

    while (True):
        data = connection.recv(1024)
        if not data: break
        connection.send(b'Echo=>' + data)
    
    connection.close()
