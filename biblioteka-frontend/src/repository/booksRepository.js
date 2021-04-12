import axios from '../custom-axios/axios'

const BookService = {
    fetchBooks: () => {
        return axios.get("/")
    }
}

export default BookService