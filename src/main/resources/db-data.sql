INSERT INTO rooms (room_number, room_type, max_occupancy, rate_per_day, active, description)
VALUES ('101', 'Suite', 4, 1000.00, true, 'Spacious suite with a view'),
       ('102', 'Standard', 2, 500.00, true, 'Cozy standard room'),
       ('103', 'Deluxe', 3, 800.00, true, 'Luxurious deluxe room'),
       ('104', 'Suite', 4, 1000.00, true, 'Elegant suite with a balcony'),
       ('105', 'Standard', 2, 500.00, true, 'Comfortable standard room'),
       ('106', 'Deluxe', 3, 800.00, true, 'Modern deluxe room'),
       ('107', 'Suite', 4, 1000.00, true, 'Executive suite with a city view'),
       ('108', 'Standard', 2, 500.00, true, 'Quaint standard room'),
       ('109', 'Deluxe', 3, 800.00, true, 'Charming deluxe room'),
       ('110', 'Suite', 4, 1000.00, true, 'Luxury suite with a spa bath');

INSERT INTO bookings (room_id, check_in_date, check_out_date, guests_amount, guests_info, creation_timestamp,
                     last_update_timestamp)
VALUES (1, '2023-09-10 14:00:00', '2023-09-15 10:00:00', 2, 'Couple', '2023-08-25 11:45:00', '2023-08-30 09:30:00'),
       (2, '2023-09-12 12:00:00', '2023-09-14 12:00:00', 1, 'Solo traveler', '2023-08-28 15:30:00',
        '2023-08-31 10:15:00'),
       (3, '2023-09-11 15:00:00', '2023-09-13 11:00:00', 3, 'Family', '2023-08-27 09:00:00', '2023-08-29 17:45:00'),
       (4, '2023-09-13 10:00:00', '2023-09-16 10:00:00', 2, 'Couple', '2023-08-26 14:15:00', '2023-08-30 11:30:00'),
       (5, '2023-09-14 13:00:00', '2023-09-18 12:00:00', 1, 'Solo traveler', '2023-08-29 10:30:00',
        '2023-09-01 14:00:00'),
       (6, '2023-09-15 16:00:00', '2023-09-17 09:00:00', 4, 'Group', '2023-08-31 12:45:00', '2023-09-02 16:30:00'),
       (7, '2023-09-16 11:00:00', '2023-09-20 10:00:00', 2, 'Couple', '2023-09-01 09:15:00', '2023-09-03 13:45:00'),
       (8, '2023-09-17 14:00:00', '2023-09-19 12:00:00', 3, 'Family', '2023-09-02 15:00:00', '2023-09-04 11:00:00'),
       (9, '2023-09-18 09:00:00', '2023-09-21 10:00:00', 1, 'Solo traveler', '2023-09-03 10:30:00',
        '2023-09-05 09:30:00'),
       (10, '2023-09-20 12:00:00', '2023-09-23 12:00:00', 2, 'Couple', '2023-09-04 14:00:00', '2023-09-06 12:15:00');