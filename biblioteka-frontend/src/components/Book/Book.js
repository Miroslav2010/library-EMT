import React from 'react'
import './Book.css'

const Book = (props) => {
    return (
        <div className="book">
            <div className="bookInfo">
                <h3>{props.book.name}</h3>
                <h5>{props.book.author.name + ' ' + props.book.author.surname}</h5>
                <h5>{props.book.category}</h5>
            </div>
            <div className="bookControls">
                <button>Edit</button>
                <button className="deleteBtn">Delete</button>
                <button>Mark as Taken</button>
            </div>
            <div className="bookCopies">
                <h5>Available copies: {props.book.availableCopies}</h5>
            </div>
        </div>
    )
}

export default Book