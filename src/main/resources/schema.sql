create table if not exists product(
    productid INT PRIMARY KEY AUTO_INCREMENT,
    productname varchar(255),
    price DOUBLE
); 

create table if not exists review(
    reviewid INT PRIMARY KEY AUTO_INCREMENT,
    reviewcontent varchar(255),
    rating INT,
    productid INT,
    FOREIGN KEY(productid) REFERENCES product(productid)
);