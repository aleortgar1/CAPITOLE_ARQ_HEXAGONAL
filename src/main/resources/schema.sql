DROP TABLE IF EXISTS prices; 
CREATE TABLE prices (
	idbrand VARCHAR(10),
	idproduct VARCHAR(10),
	pricelist  INTEGER,
	startdate VARCHAR(30),
	enddate VARCHAR(30),
	priority VARCHAR(10),
	price VARCHAR(30),
	curr VARCHAR(10)
);