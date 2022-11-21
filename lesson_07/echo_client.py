import sys
from socket import *

server_host = 'localhost'
server_port = 8189

message = [b'Hello network world']

if len(sys.argv) > 1:
    server_host = sys.argv[1]
    if len(sys.argv) > 2:
        message = (x.encode() for x in sys.argv[2:])

sockobj = socket(AF_INET, SOCK_STREAM)
sockobj.connect((server_host, server_port))

for line in message:
    sockobj.send(line)
    data = sockobj.recv(1024)
    print('Client received:', data)

sockobj.close()