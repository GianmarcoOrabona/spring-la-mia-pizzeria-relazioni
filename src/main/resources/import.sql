INSERT INTO pizzas (price, img_url, name, description) VALUES (8.50, 'https://images.unsplash.com/photo-1574071318508-1cdbab80d002?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8cGl6emElMjBtYXJnaGVyaXRhfGVufDB8fDB8fHww', 'Margherita', 'Pomodoro, Mozzarella, Basilico');
INSERT INTO pizzas (price, img_url, name, description) VALUES (9.75, 'https://it.wikipedia.org/wiki/Pizza_alla_marinara#/media/File:Pizza_marinara.jpg', 'Napoletana', 'Pomodoro, Mozzarella di Bufala, Acciughe, Olive, Origano');
INSERT INTO pizzas (price, img_url, name, description) VALUES (10.00, 'https://i0.wp.com/www.piccolericette.net/piccolericette/wp-content/uploads/2016/07/3017_Pizza.jpg?resize=895%2C616&ssl=1', 'Quattro Stagioni', 'Pomodoro, Mozzarella, Funghi, Carciofi, Prosciutto Cotto, Olive Nere');
INSERT INTO pizzas (price, img_url, name, description) VALUES (9.25, 'https://it.wikipedia.org/wiki/Pizza_alla_marinara#/media/File:Pizza_marinara.jpg', 'Marinara', 'Pomodoro, Aglio, Origano, Olive, Acciughe');
INSERT INTO pizzas (price, img_url, name, description) VALUES (11.50, 'https://www.buttalapasta.it/wp-content/uploads/2017/11/pizza-capricciosa.jpg', 'Capricciosa', 'Pomodoro, Mozzarella, Prosciutto Cotto, Funghi, Carciofi, Olive');
INSERT INTO pizzas (price, img_url, name, description) VALUES (10.75, 'https://thealmondeater.com/wp-content/uploads/2021/03/Kale-Pesto-Pizza-1-6-min.jpg', 'Pesto', 'Pesto Genovese, Mozzarella, Pomodorini, Pinoli, Parmigiano');
INSERT INTO pizzas (price, img_url, name, description) VALUES (11.25, 'https://blog.giallozafferano.it/zeroglutine/wp-content/uploads/2020/04/IMG_5544-720x411.jpg', 'Quattro Formaggi', 'Gorgonzola, Fontina, Mozzarella, Parmigiano');
INSERT INTO pizzas (price, img_url, name, description) VALUES (10.50, 'https://i2.wp.com/www.piccolericette.net/piccolericette/wp-content/uploads/2020/09/4460_Calzoni.jpg?resize=895%2C616&ssl=1', 'Calzone', 'Pomodoro, Mozzarella, Prosciutto Cotto, Funghi, Ricotta');
INSERT INTO pizzas (price, img_url, name, description) VALUES (9.00, 'https://staticcookist.akamaized.net/wp-content/uploads/sites/21/2020/05/pizza-con-melanzane-1200x675.jpg', 'Melanzane', 'Pomodoro, Mozzarella, Melanzane Grigliate, Parmigiano, Basilico');
INSERT INTO pizzas (price, img_url, name, description) VALUES (12.00, 'https://www.acouplecooks.com/wp-content/uploads/2018/09/Diavola-Pizza-0014.jpg', 'Italiana', 'Pomodoro, Mozzarella, Salame Piccante, Peperoni, Olive Nere');

-- Insert Discount
INSERT INTO discounts (expire_date, pizza_id, start_date, title) VALUES ('2028-05-29', 1, '2023-09-02', '10% Discount');
INSERT INTO discounts (expire_date, pizza_id, start_date, title) VALUES ('2024-08-15', 2, '2023-10-18', '15% Off Special');
INSERT INTO discounts (expire_date, pizza_id, start_date, title) VALUES ('2024-06-30', 3, '2023-11-05', '20% Discount Deal');
INSERT INTO discounts (expire_date, pizza_id, start_date, title) VALUES ('2024-09-22', 4, '2024-01-12', '12% Off Combo');
INSERT INTO discounts (expire_date, pizza_id, start_date, title) VALUES ('2023-10-15', 5, '2023-10-10', '25% Pizza Fest');
INSERT INTO discounts (expire_date, pizza_id, start_date, title) VALUES ('2024-08-25', 6, '2023-09-22', '18% Off Extravaganza');
INSERT INTO discounts (expire_date, pizza_id, start_date, title) VALUES ('2024-06-15', 7, '2023-11-28', 'Free Topping Tuesday');
INSERT INTO discounts (expire_date, pizza_id, start_date, title) VALUES ('2024-09-05', 8, '2024-01-02', 'Buy 1 Get 1 Free');
INSERT INTO discounts (expire_date, pizza_id, start_date, title) VALUES ('2024-12-20', 9, '2023-10-10', '30% Mega Discount');
INSERT INTO discounts (expire_date, pizza_id, start_date, title) VALUES ('2023-10-15', 10, '2023-10-10', 'Special Weekend Offer');