CREATE TABLE IF NOT EXISTS rooms (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      room_number VARCHAR(10),
                      room_type VARCHAR(20),
                      max_occupancy INT,
                      rate_per_day DECIMAL(10, 2),
                      active BOOLEAN,
                      description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS bookings (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         room_id INT,
                         check_in_date TIMESTAMP,
                         check_out_date TIMESTAMP,
                         guests_amount INT,
                         guests_info VARCHAR(255),
                         creation_timestamp TIMESTAMP,
                         last_update_timestamp TIMESTAMP
);