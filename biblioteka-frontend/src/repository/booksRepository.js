import axios from '../custom-axios/axios'

const BookService = {
    fetchBooks: () => {
        return axios.get("/")
    },
    addBook: (name, author, availableCopies, category) => {
        return axios.post("/books/add", {
            "name" : name,
            "author" : author,
            "availableCopies" : availableCopies,
            "category" : category
        });
    },
    editBook: (id, name, author, availableCopies, category) => {
        return axios.put(`/books/edit/${id}`, {
            "name" : name,
            "author" : author,
            "availableCopies" : availableCopies,
            "category" : category
        });
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`)
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`)
    },
    markAsTaken: (id) => {
        return axios.post(`/books/markTaken/${id}`)
    }
}

export default BookService