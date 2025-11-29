INSERT INTO category (name, image, enabled, parent_id)
VALUES
    ('Instruments', NULL, true, NULL),   -- id = 1
    ('Accessories', NULL, true, NULL),   -- id = 2
    ('Albums', NULL, true, NULL),        -- id = 3
    ('Merchandise', NULL, true, 2),   -- id = 4
    ('Audio', NULL, true, NULL);         -- id = 5


INSERT INTO product
(name, short_description, full_description, brand, category_id,
 list_price, discount, cost, enabled, in_stock, creation_time, update_time,
 length, width, height, weight)
VALUES
-- 🎸 Instruments (category_id = 1)
('Acoustic Folk Guitar', 'Acoustic guitar', 'Full–size acoustic folk guitar with spruce top',
 'Yamaha', 1, 1299.00, 100.00, 600.00, true, true, NOW(), NOW(),
 100, 35, 10, 3.5),

('Digital Keyboard 61', '61-key keyboard', '61-key digital keyboard with learning modes',
 'Casio', 1, 899.90, 50.00, 350.00, true, true, NOW(), NOW(),
 95, 30, 12, 5.0),

('Jazz Bass Classic', 'Electric bass', '4-string electric bass ideal for jazz and funk',
 'Fender', 1, 2999.00, 150.00, 1200.00, true, true, NOW(), NOW(),
 105, 34, 11, 4.0),

-- 🥁 Accessories (category_id = 2)
('Guitar Strap Vintage', 'Guitar strap', 'Adjustable vintage leather guitar strap',
 'Ernie Ball', 2, 149.90, 20.00, 45.00, true, true, NOW(), NOW(),
 20, 10, 5, 0.3),

('Guitar Cable 10ft', 'Instrument cable', '10ft shielded instrument cable for guitar/bass',
 'Planet Waves', 2, 99.90, 10.00, 30.00, true, true, NOW(), NOW(),
 15, 10, 5, 0.2),

('Drum Practice Pad', 'Practice pad', '12-inch drum practice pad with rubber surface',
 'Evans', 2, 189.90, 0.00, 70.00, true, true, NOW(), NOW(),
 25, 25, 5, 1.2),

-- 💿 Albums (category_id = 3)
('Back in Black CD', 'AC/DC album', 'Original AC/DC Back in Black CD (1980)',
 'Columbia Records', 3, 44.90, 0.00, 12.00, true, true, NOW(), NOW(),
 14, 12, 1, 0.1),

('Abbey Road CD', 'Beatles album', 'The Beatles’ Abbey Road — remastered edition',
 'Apple Records', 3, 49.90, 5.00, 13.00, true, true, NOW(), NOW(),
 14, 12, 1, 0.1),

('Random Access Memories CD', 'Daft Punk album', 'Daft Punk — Random Access Memories (2013)',
 'Daft Life', 3, 59.90, 10.00, 16.00, true, true, NOW(), NOW(),
 14, 12, 1, 0.1),

-- 👕 Merchandise (category_id = 4)
('Metallica Hoodie', 'Official hoodie', 'Black official Metallica hoodie with band logo',
 'RockWear', 4, 199.90, 20.00, 70.00, true, true, NOW(), NOW(),
 30, 25, 3, 0.5),

('Nirvana T-Shirt', 'Official t-shirt', 'Official Nirvana T-shirt with iconic smiley logo',
 'RockWear', 4, 89.90, 0.00, 28.00, true, true, NOW(), NOW(),
 30, 25, 2, 0.3),

('Queen Poster Pack', '6 posters set', 'Poster set with 6 Queen album designs',
 'FanArt', 4, 69.90, 5.00, 15.00, true, true, NOW(), NOW(),
 42, 30, 3, 0.4),

-- 🎧 Audio Equipment (category_id = 5)
('USB Condenser Microphone', 'Studio microphone', 'USB condenser microphone for streaming and recording',
 'Blue', 5, 499.00, 30.00, 150.00, true, true, NOW(), NOW(),
 28, 12, 12, 0.8),

('Portable Audio Interface', 'USB interface', '2-in/2-out portable USB audio interface',
 'Focusrite', 5, 899.00, 70.00, 280.00, true, true, NOW(), NOW(),
 32, 20, 8, 1.3),

('Studio Monitor Pair', 'Studio speakers', 'Pair of flat-response studio monitor speakers',
 'KRK', 5, 1499.00, 120.00, 600.00, true, true, NOW(), NOW(),
 40, 30, 30, 7.0);

-- ============================================================
--  PRODUCT DETAILS (automáticos por categoria)
--  OBS: Assumindo que os produtos acima criam IDs 1..15
-- ============================================================

-- 🎸 Instruments
INSERT INTO product_detail (name, value, product_id) VALUES
                                                         ('Material', 'Spruce + Mahogany', 1),
                                                         ('Type', 'Acoustic Guitar', 1),
                                                         ('Color', 'Natural Wood', 1),

                                                         ('Keys', '61', 2),
                                                         ('Mode', 'Learning Mode', 2),
                                                         ('Power', 'AC Adapter', 2),

                                                         ('Strings', '4-string', 3),
                                                         ('Genre Fit', 'Jazz / Funk', 3),
                                                         ('Body', 'Alder', 3);

-- 🥁 Accessories
INSERT INTO product_detail (name, value, product_id) VALUES
                                                         ('Material', 'Leather', 4),
                                                         ('Color', 'Brown', 4),

                                                         ('Length', '3 meters (10ft)', 5),
                                                         ('Connector', '1/4" TS', 5),

                                                         ('Diameter', '12 inch', 6),
                                                         ('Surface', 'Rubber', 6);

-- 💿 Albums
INSERT INTO product_detail (name, value, product_id) VALUES
                                                         ('Release Year', '1980', 7),
                                                         ('Genre', 'Rock', 7),

                                                         ('Release Year', '1969', 8),
                                                         ('Genre', 'Rock', 8),

                                                         ('Release Year', '2013', 9),
                                                         ('Genre', 'Electronic', 9);

-- 👕 Merchandise
INSERT INTO product_detail (name, value, product_id) VALUES
                                                         ('Material', 'Cotton', 10),
                                                         ('Size', 'M', 10),

                                                         ('Material', 'Cotton', 11),
                                                         ('Size', 'M', 11),

                                                         ('Material', 'Paper', 12),
                                                         ('Print Count', '6 Posters', 12);

-- 🎧 Audio Equipment
INSERT INTO product_detail (name, value, product_id) VALUES
                                                         ('Connectivity', 'USB', 13),
                                                         ('Frequency Response', '20Hz–20kHz', 13),

                                                         ('Inputs', '2', 14),
                                                         ('Outputs', '2', 14),

                                                         ('Power', '100W', 15),
                                                         ('Frequency Response', 'Flat', 15);
