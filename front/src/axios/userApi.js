import { customAxios } from "./customAxios";

export const userLogin = async(dto) => {
    await customAxios.post('/login', dto)
    .then((res) => {
        console.log(res);
    });
}

export const idCheck = async(dto) => {
    const result = await customAxios.get(`/idcheck?membId=${dto.membId}`)
    return result;
}