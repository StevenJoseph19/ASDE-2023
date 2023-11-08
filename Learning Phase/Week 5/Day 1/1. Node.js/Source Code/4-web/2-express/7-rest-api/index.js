const express = require('express');
const app = express();
app.use(express.json());


app.post('/user/3', (req, res) => {
    const {name} = req.body;
    if (!name) {
      res.status(400).send({ message: "Please add name of user"});
    }
    res.send({ name: name, id: 3});
  });

  app.get('/users', (req, res) =>  
         res.status(200).send([ {name: 'John', id: 1}, {name: 'Sunil', id: 2}, ]));

app.listen(3000, () => console.log('App is running'));


