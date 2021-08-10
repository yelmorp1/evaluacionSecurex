const http = require('http');
const app = require('express')();
const hostname = '127.0.0.1';
const port = 3000;

const server = http.createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  res.end('Hello World');
});

var mainRouter = require('./routes/mainRouter');
//const PORT = process.env.PORT || 8081;

function myCors(req, res, nxt) {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Methods', 'GET,PUT,OPTIONS');
    res.header('Access-Control-Allow-Headers', 'Access-Control-Allow-Origin, Content-Type, Accept, Accept-Language, Origin, User-Agent');
    if(req.method === 'OPTIONS') {
        res.sendStatus(204);
    }
    else {
        nxt();
    }
}

app.use(myCors);
app.use('/main', mainRouter);

app.listen(port, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});
