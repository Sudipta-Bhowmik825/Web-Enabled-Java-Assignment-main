const express = require('express');
const bodyParser = require('body-parser');
const path = require('path');

const app = express();
const PORT = 3000;
const users = [
    { username: 'subhamay', password: '123' },
    { username: 'admin', password: '123' },
];
app.use(bodyParser.json());
app.use(express.static(path.join(__dirname, 'public')));
app.post('/login', (req, res) => {
    const { username, password } = req.body;
    const user = users.find(u => u.username === username && u.password === password);
    if (user) {
        res.json({ message: 'Login successful' });
    } else {
        res.status(401).json({ message: 'Invalid username or password' });
    }
});

app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});
