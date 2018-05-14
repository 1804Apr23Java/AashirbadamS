
function Addbook() {


    var b= document.getElementsByClassName("BookSelf");
    console.log(b);   

   var books = document.querySelectorAll(".BookSelf");
   console.log(books);    
    books.forEach(function (books) {        
     console.log(books.innerHTML);
       books.addEventListener("submit",function(){


        })

     });
} 

function addelement(){
    var book = {
        title: "title1",
        author: "author1",
        genra: "genra1",
        coverimage:"coverimage"
    };
    var books=document.getElementsByTagName("div");
    
   var bookadded= books.document.appendChild(book);

}
  
    
