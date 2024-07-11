DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS dealerships;
DROP TABLE IF EXISTS vehicles;
DROP TABLE IF EXISTS customers;

CREATE TABLE dealerships (
    dealership_id serial primary key,
    name varchar(50),
    address varchar(50),
    phone varchar(12)
);

CREATE TABLE vehicles (
    vehicle_id serial primary key,
    vin varchar(17),
    sold boolean,
    make varchar(50),
    model varchar(50),
    year smallint,
    vehicle_type varchar(50),
    color varchar(50),
    odometer int,
    price decimal (10,2)
);

CREATE TABLE inventory (
    dealership_id smallint not null,
    vehicle_id smallint not null,
        foreign key (dealership_id) references dealerships(dealership_id),
        foreign key (vehicle_id) references vehicles(vehicle_id)
);

CREATE TABLE customers (
    customer_id serial primary key,
    first_name varchar(50),
    last_name varchar(50),
    phone varchar(12),
    address varchar(50)
);

-- Inserting data into dealerships
INSERT INTO dealerships (name, address, phone) VALUES
('Thrift Throttle', '123 Main St', '123-456-7890'),
('Zoom Zone', '456 High St', '234-567-8901');

-- Inserting data into vehicles
INSERT INTO vehicles (vin, sold, make, model, year, vehicle_type, color, odometer, price) VALUES
('1HGCM82633A123456', false, 'Honda', 'Accord', 2003, 'SEDAN', 'Blue', 120000, 5000.00),
('1HGCM82633A123457', false, 'Toyota', 'Camry', 2005, 'SEDAN', 'Red', 110000, 5500.00),
('1HGCM82633A123458', false, 'Ford', 'Fusion', 2007, 'SEDAN', 'White', 130000, 6000.00),
('1HGCM82633A123459', false, 'Chevrolet', 'Malibu', 2009, 'SEDAN', 'Black', 140000, 6500.00),
('1HGCM82633A123460', false, 'Nissan', 'Altima', 2011, 'SEDAN', 'Silver', 150000, 7000.00),
('1HGCM82633A123461', false, 'Hyundai', 'Sonata', 2013, 'SEDAN', 'Gray', 160000, 7500.00),
('1HGCM82633A123462', false, 'Kia', 'Optima', 2015, 'SEDAN', 'Blue', 170000, 8000.00),
('1HGCM82633A123463', false, 'Subaru', 'Legacy', 2017, 'SEDAN', 'Red', 180000, 8500.00),
('1HGCM82633A123464', false, 'Mazda', '6', 2019, 'SEDAN', 'White', 190000, 9000.00),
('1HGCM82633A123465', false, 'Volkswagen', 'Passat', 2021, 'SEDAN', 'Black', 200000, 9500.00);

-- Inserting data into inventory
INSERT INTO inventory (dealership_id, vehicle_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(2, 6),
(2, 7),
(2, 8),
(2, 9),
(2, 10);

-- Inserting data into customers
INSERT INTO customers (first_name, last_name, phone, address) VALUES
('John', 'Doe', '345-678-9012', '789 Low St'),
('Jane', 'Doe', '456-789-0123', '012 High Ave');

