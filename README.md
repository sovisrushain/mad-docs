# Entity-Relationship Diagram

    +-------------+
    |    User     |
    +-------------+
    | userId (PK) |
    | name        |
    | email       |
    | password    |
    | address     |
    | phoneNumber |
    +-------------+
          |
          | (1..*)
          |
    +----------------+
    |   Booking      |  
    +----------------+  
    | bookingId (PK) |
    | userId (FK)    |
    | doctorId (FK)  |
    | hospitalId (FK)|
    | bookingDate    |
    | timeSlot       |
    | paymentStatus  |
    +----------------+
          |
          | (0..1)
          |
    +----------------+
    |   Payment      |
    +----------------+
    | paymentId (PK) |
    | bookingId (FK) |
    | amount         |
    | paymentDate    |
    | status         |
    +----------------+
 
    +---------------+
    |   Doctor      |
    +---------------+
    | doctorId (PK) |
    | name          |
    | specialization|
    +---------------+
          |
          | (1..*)
          |
    +----------------+
    | DoctorSchedule |
    +----------------+
    | scheduleId (PK)|
    | doctorId (FK)  |
    | hospitalId (FK)|
    | dayOfWeek      |
    | maxPatients    |
    +----------------+
    
    +-----------------+
    |  Hospital       |
    +-----------------+
    | hospitalId (PK) |
    | name            |
    | address         |
    +-----------------+