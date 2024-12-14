-- Table for Room entity
CREATE TABLE Room (
    roomId INT AUTO_INCREMENT PRIMARY KEY,
    roomNumber INT NOT NULL,
    type ENUM('SINGLE', 'DOUBLE', 'SUITE') NOT NULL,
    isAvailable BOOLEAN NOT NULL
);

-- Table for Guest entity
CREATE TABLE Guest (
    guestId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- Table for Reservation entity
CREATE TABLE Reservation (
    reservationId INT AUTO_INCREMENT PRIMARY KEY,
    guestId INT NOT NULL,
    roomId INT NOT NULL,
    checkInDate DATE NOT NULL,
    checkOutDate DATE NOT NULL,
    isCheckedIn BOOLEAN NOT NULL DEFAULT 0,
    isCheckedOut BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (guestId) REFERENCES Guest(guestId),
    FOREIGN KEY (roomId) REFERENCES Room(roomId)
);

-- Table for Bill entity
CREATE TABLE Bill (
    billId INT AUTO_INCREMENT PRIMARY KEY,
    reservationId INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    isPaid BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (reservationId) REFERENCES Reservation(reservationId)
);
