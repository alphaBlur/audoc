var express = require('express'),
	http = require('http').Server(app),
	app = express(),
	server = require('http').createServer(app),
	io = require('socket.io').listen(server);

app.get('/', function(req,res){
	res.sendFile(__dirname + '/clock.html');
});

io.sockets.on('connection',function(socket){
	socket.on('new time', function(data){
		console.log(data);
		io.sockets.emit('update time',data);
	});
});

server.listen(3005 , function(){
	console.log('Listening on 3005');
});