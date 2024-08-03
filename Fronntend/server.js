const express = require('express');
const http = require('http');
const socketIo = require('socket.io');
const path = require('path');
const axios = require('axios');
const app = express();
const server = http.createServer(app);
const io = socketIo(server);

// Serve static files (e.g., HTML, CSS, JS)
app.use(express.static(path.join(__dirname, 'public')));

// Handle the main route
app.get('/', (req, res) => {
    res.sendFile(__dirname + '/public/index.html');
});

// Set up a simple WebSocket connection
io.on('connection', (socket) => {
    console.log('A user connected');
    socket.on('disconnect', () => {
        console.log('User disconnected');
    });
});



// Example function to fetch data from a Spring Boot API
async function fetchData() {
    try {
        const response = await axios.get('http://localhost:3306/SocialMediaDatabase'); // Replace with your Spring Boot API URL
        console.log(response.data);
        // Process the data as needed
    } catch (error) {
        console.error('Error fetching data:', error);
    }
}

fetchData();


// Start the server
const PORT = process.env.PORT || 3000;
server.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});
