import axios from 'axios'

const instance = axios.create({
    baseURL: 'http://localhost:8080/api',
    headers: {
        'Access-control-allow-origin':'*'
    }
})

export default instance