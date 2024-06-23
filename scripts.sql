
-- Creating the User table
CREATE TABLE user (
                      user_id VARCHAR(255) PRIMARY KEY,
                      user_name VARCHAR(255) NOT NULL,
                      user_email VARCHAR(255) UNIQUE NOT NULL,
                      user_password VARCHAR(255) NOT NULL,
                      user_address TEXT,
                      user_phone VARCHAR(20)
);

-- Creating the Doctor table
CREATE TABLE doctor (
                        doctor_id VARCHAR(255) PRIMARY KEY,
                        doctor_name VARCHAR(255) NOT NULL,
                        doctor_specialization VARCHAR(255) NOT NULL
);

-- Creating the Hospital table
CREATE TABLE hospital (
                          hospital_id VARCHAR(255) NOT NULL PRIMARY KEY,
                          hospital_name VARCHAR(255) NOT NULL,
                          hospital_address VARCHAR(255) NOT NULL
);

-- Creating the Booking table
CREATE TABLE booking (
                         booking_id VARCHAR(255) PRIMARY KEY,
                         user_id VARCHAR(255) NOT NULL,
                         doctor_id VARCHAR(255) NOT NULL,
                         hospital_id VARCHAR(255) NOT NULL,
                         booking_date DATE NOT NULL,
                         time_slot VARCHAR(50) NOT NULL,
                         payment_status VARCHAR(50) NOT NULL,
                         FOREIGN KEY (user_id) REFERENCES user(user_id),
                         FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
                         FOREIGN KEY (hospital_id) REFERENCES hospital(hospital_id)
);

-- Creating the Payment table
CREATE TABLE payment (
                         payment_id VARCHAR(255) PRIMARY KEY,
                         booking_id VARCHAR(255) UNIQUE,
                         amount DECIMAL(10, 2) NOT NULL,
                         payment_date DATE NOT NULL,
                         status VARCHAR(50) NOT NULL,
                         FOREIGN KEY (booking_id) REFERENCES booking(booking_id)
);

-- Creating the DoctorSchedule table
CREATE TABLE doctor_schedule (
                                 schedule_id VARCHAR(255) PRIMARY KEY,
                                 doctor_id VARCHAR(255) NOT NULL,
                                 hospital_id VARCHAR(255) NOT NULL,
                                 day_of_week VARCHAR(50) NOT NULL,
                                 max_patients INTEGER NOT NULL,
                                 FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
                                 FOREIGN KEY (hospital_id) REFERENCES hospital(hospital_id)
);
