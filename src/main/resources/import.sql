INSERT INTO locations VALUES (1, 'Novi Sad', FALSE , '21000');
INSERT INTO locations VALUES (2, 'Beograd', FALSE , '11000');
INSERT INTO locations VALUES (3, 'Nis', FALSE , '18000');
INSERT INTO locations VALUES (4, 'Subotica', FALSE , '24000');

INSERT INTO companies VALUES (1, 'Zitni trg 4', FALSE, 'ortodynamic@gmail.com', 'Dynamic Pro', '021636232', '257195727', 1);
INSERT INTO companies VALUES (2, 'Terazije 36', FALSE, 'duhovneoci@gmail.com', 'Duhovne oci', '011284828', '457296317', 2);
INSERT INTO companies VALUES (3, 'Sumadijska 40', FALSE, 'collective.design@gmail.com', 'The Collective', '01828382', '148229292', 3);
INSERT INTO companies VALUES (4, 'Korzo 1', FALSE, 'vinopromet@gmail.com', 'Vinopromet', '024747742', '2929929329', 4);

INSERT INTO business_partner VALUES (1, 'Gogoljeva 4', 'BUYER', '2020-03-02', FALSE, 'Zivojin', '2992929', 1, 1);
INSERT INTO business_partner VALUES (2, 'Terazije 2', 'BUYER', '2020-02-12', FALSE, 'Vukojica', '2459929', 2, 2);
INSERT INTO business_partner VALUES (3, 'Sumadijska 22', 'BUYER_AND_SUPPLIER', '2020-02-03', FALSE, 'Stefan','2424242', 3, 3);
INSERT INTO business_partner VALUES (4, 'Licka 6', 'BUYER', '2020-04-01', FALSE, 'Marica', '8282828', 4, 4);

INSERT INTO business_year VALUES (1, '2021-04-03', FALSE, '2020-04-03', '2020', 1);
INSERT INTO business_year VALUES (2, '2021-04-02', FALSE, '2020-04-02', '2020', 2);
INSERT INTO business_year VALUES (3, '2021-04-01', FALSE, '2020-04-01', '2020', 3);
INSERT INTO business_year VALUES (4, '2021-04-04', FALSE, '2020-04-04', '2020', 4);

INSERT INTO carriers VALUES (1, FALSE, 'Bex');
INSERT INTO carriers VALUES (2, FALSE, 'D Express');
INSERT INTO carriers VALUES (3, FALSE, 'AKS');
INSERT INTO carriers VALUES (4, FALSE, 'Post Express');

INSERT INTO users VALUES (1, FALSE, '$10$98JlHkuUTBSD8T4LJm6ZYuj8qls5QXCl39MasMUaojMWiSWIsjKN2', 'ADMIN', '1', 1);
INSERT INTO users VALUES (2, FALSE, '$10$Mo9d058uPWYq9F2u27NIT.ESnlhLEBOU8FBYzKtFP9olt6rQr7ep2', 'ADMIN', '2', 2);
INSERT INTO users VALUES (3, FALSE, '$10$aKcC95Bk8VMnlrMYkY0R.OAROiesUCdQ3/NzVqAz2fXe1GZ9MUknG', 'USER', '3', 3);
INSERT INTO users VALUES (4, FALSE, '$2a$10$VONABH7lVE7IIi7l3a9kKeetbzDftLieifQlxbPBNOo35EgzkJZgi', 'USER', '4', 4);


--
--
--
-- INSERT INTO 'dispatch_note' ('dispatch_note_id', 'dispatch_note_date', 'deleted', 'delivery_date', 'dispatch_note_number',
--                              'received_goods', 'business_partner_id', 'carrier_id', 'company_id', 'invoice_id',
--                              'user_id');
--                                 VALUES ();
--
-- INSERT INTO 'dispatch_note_items' ('dispatch_note_item_id', 'deleted', 'delivered_quantity', 'measure_of_unit', 'name',
--                                    'note', 'dispatch_note_item_number', 'price', 'dispatch_note_id', 'goods_id')
--                                 VALUES ();
--
-- INSERT INTO 'goods' ('goods_id', 'deleted', 'name', 'measure_of_unit', 'goods_group_id')
--                                 VALUES ();
--
-- INSERT INTO 'goods_groups' ('goods_group_id', 'creation_date', 'deleted', 'name', 'company_id', 'vat_id')
--                                 VALUES ();
--
-- INSERT INTO 'invoice_items' ('invoice_item_id', 'base_for_vat', 'deleted', 'item_amount', 'quantity', 'rebate',
--                              'unit_of_measure', 'unit_price', 'vat_amount', 'vat_percent', 'goods_id', 'invoice_id')
--                                 VALUES ();
--
-- INSERT INTO 'invoices' ('invoice_id', 'amount_to_be_paid', 'base', 'currency_date', 'deleted', 'invoice_date',
--                         'invoice_number', 'invoice_status', 'vat_total', 'business_partner_id', 'company',
--                         'dispatch_note', 'receiving_order', 'user_id')
--                                 VALUES ();
--
--
--
-- INSERT INTO 'pricelist_items' ('pricelist_item_id', 'deleted', 'price', 'goods_id', 'pricelist_id')
--                                 VALUES ();
--
-- INSERT INTO 'pricelists' ('pricelist_id', 'active', 'creation_date', 'deleted', 'expiration_date', 'serial_number',
--                           'company_id')
--                                 VALUES ();
--
-- INSERT INTO 'receiving_order_items' ('receiving_order_item_id', 'deleted', 'name', 'quantity', 'unit_of_measure',
--                                      'goods_id', 'receiving_order_id')
--                                 VALUES ();
--
-- INSERT INTO 'receiving_orders' ('receiving_order_id', 'active', 'creation_date', 'deleted', 'delivery_date', 'number',
--                                 'business_partner_id', 'companies', 'invoice_id', 'user_id')
--                                 VALUES ();
--

--
-- INSERT INTO 'vat' ('vat_id', 'deleted', 'name')
--                                 VALUES ();
--
-- INSERT INTO 'vat_rates' ('vat_rate_id', 'deleted', 'expiration_date', 'percent', 'vat_id')
--                                 VALUES ();
--
--
--
