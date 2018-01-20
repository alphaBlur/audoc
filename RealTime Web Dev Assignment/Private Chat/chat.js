var express = require('express'),
app = express(),
server = require('http').createServer(app),
io = require('socket.io').listen(server),
nicknames = [];
allSockets = {};

server.listen(3000);
 
app.get('/', function(req, res){
res.sendFile(__dirname + '/index.html');
});
 
io.sockets.on('connection', function(socket){
socket.on('new user', function(data, callback){
if(nicknames.indexOf(data) != -1){
callback(false);
} else{
socket.nickname = data;
nicknames.push(socket.nickname);
allSockets[socket.nickname] = socket;
io.sockets.emit('usernames', nicknames);
callback(true);
updateNicknames();
}
});
 
function updateNicknames(){
io.sockets.emit('usernames', nicknames);
}
 
socket.on('send message', function(data){
    
let nick = data.to;
data.from = socket.nickname;

if(allSockets[nick]!=undefined){
    let find = allSockets[nick];
    find.emit('new message',data);
}
});
 
socket.on('disconnect', function(data){
if(!socket.nickname) return;
nicknames.splice(nicknames.indexOf(socket.nickname), 1);
updateNicknames();
});
});