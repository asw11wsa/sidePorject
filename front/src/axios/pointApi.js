import { customAxios } from "./customAxios";

export const myPoint = async (dto) => {
    try{
        const result = await customAxios.post('/user/point',dto);
        return result;
    }catch(e){
        console.log(e);
    }
}