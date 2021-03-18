import axios from 'axios';

const http = axios.create({baseURL:"http://localhost:8090/api/"});

export default {
    getCurrentStatus() {
        return http.get('status/current');
    }
}