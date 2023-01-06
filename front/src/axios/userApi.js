import { customAxios } from "./customAxios";

export const userLogin = async(dto) => {
    try{
        const result = await customAxios.post('/login', dto);
        return result;
    }catch(err){
        console.log(err);
    }
}

export const idCheck = async(dto) => {
    const result = await customAxios.get(`/idcheck?membId=${dto.membId}`);
    return result;
}