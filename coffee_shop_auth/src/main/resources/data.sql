
INSERT INTO tbl_role (id, name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO tbl_role (id, name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');


INSERT INTO public.tbl_product
(current_price, description, enjoyed, reviews_count, votes_count, original_price, privew_images, rating, stock_count, threshold_stock_count, title)
VALUES(180, 'Coffee of the Day', 92, 41, 30, 180, '../../../assets/img/coffee-1.jpg,../../../assets/img/coffee-2.jpg,../../../assets/img/coffee-3.jpg', '3', 5, 4, 'Filter Coffee');
INSERT INTO public.tbl_product
(current_price, description, enjoyed, reviews_count, votes_count, original_price, privew_images, rating, stock_count, threshold_stock_count, title)
VALUES(200, 'Cappuccino of the Day', 30, 45, 11, 220, '../../../assets/img/coffee-2.jpg,../../../assets/img/coffee-1.jpg,../../../assets/img/coffee-3.jpg', '4', 2, 4, 'Cappuccino');
INSERT INTO public.tbl_product
(current_price, description, enjoyed, reviews_count, votes_count, original_price, privew_images, rating, stock_count, threshold_stock_count, title)
VALUES(210, 'Hot Chocolate', 98, 10, 30, 230, '../../../assets/img/coffee-3.jpg,../../../assets/img/coffee-2.jpg,../../../assets/img/coffee-1.jpg', '5', 4, 4, 'Filter Coffee');


INSERT INTO public.tbl_user
(dob, email, "name", "password")
VALUES('30/05/1992', 'amitkdas@1.com', 'amit', '$2a$10$rRcKIOrTGUto5b8m6bUcGOocp9pHXV48is1F/OCfTM7fAc4E5lesu');

INSERT INTO public.tbl_user_role
(id, role_id)
VALUES(1, 1);



INSERT INTO public.tbl_order
(date_time, status, total)
VALUES((TIMESTAMP '2011-05-16 15:36:38'), 'SAVED', '450');
INSERT INTO public.tbl_order
(date_time, status, total)
VALUES((TIMESTAMP '2012-05-16 15:36:38'), 'CONFIRMING', '350');
INSERT INTO public.tbl_order
(date_time, status, total)
VALUES((TIMESTAMP '2013-05-16 15:36:38'), 'PREPARING', '250');
INSERT INTO public.tbl_order
(date_time, status, total)
VALUES((TIMESTAMP '2014-05-16 15:36:38'), 'OUT_FOR_DELIVERY', '650');
INSERT INTO public.tbl_order
(date_time, status, total)
VALUES((TIMESTAMP '2015-05-16 15:36:38'), 'DELIVERED', '550');


INSERT INTO public.tbl_user_order
(user_id, order_id)
VALUES(1, 1);
INSERT INTO public.tbl_user_order
(user_id, order_id)
VALUES(1, 2);
INSERT INTO public.tbl_user_order
(user_id, order_id)
VALUES(1, 3);
INSERT INTO public.tbl_user_order
(user_id, order_id)
VALUES(1, 4);
INSERT INTO public.tbl_user_order
(user_id, order_id)
VALUES(1, 5);

INSERT INTO public.tbl_order_product
(order_id, product_id)
VALUES(1, 1);
INSERT INTO public.tbl_order_product
(order_id, product_id)
VALUES(1, 2);
INSERT INTO public.tbl_order_product
(order_id, product_id)
VALUES(2, 3);
INSERT INTO public.tbl_order_product
(order_id, product_id)
VALUES(2, 1);
INSERT INTO public.tbl_order_product
(order_id, product_id)
VALUES(3, 1);
INSERT INTO public.tbl_order_product
(order_id, product_id)
VALUES(3, 2);
INSERT INTO public.tbl_order_product
(order_id, product_id)
VALUES(3, 3);
INSERT INTO public.tbl_order_product
(order_id, product_id)
VALUES(4, 3);
INSERT INTO public.tbl_order_product
(order_id, product_id)
VALUES(5, 2);
