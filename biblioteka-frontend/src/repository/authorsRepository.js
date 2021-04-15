import axios from '../custom-axios/axios'

const AuthorService = {
    fetchAuthors: () => {
        return axios.get("/authors")
    }
}

export default AuthorService