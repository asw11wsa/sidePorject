import axios from "axios";
import cookies from 'js-cookie';

export const customAxios = axios.create({
    baseURL : `${process.env.REACT_APP_SERVER_ADDRESS}`,
    headers: {
        access_token: cookies.get('access_token'),
    }
})