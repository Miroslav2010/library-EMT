import React from 'react'
import Book from '../Book/Book'

const Books = (props) => {
    return (
        
        <div className="App">
            <h3>Available books:</h3>
            {props.books.map(
            (book) => {
                return (
                    <Book key={book.id} book={book} />
                )
            }  
            )}
        </div>
    )
}

export default Books;