SELECT * FROM dealerships;


SELECT * FROM vehicles
JOIN inventory on  vehicles.vehicle_id = inventory.vehicle_id
WHERE inventory.dealership_id = 1;

SELECT * FROM vehicles
WHERE vin = '1HGCM82633A123458';

SELECT dealerships.name, dealerships.address
FROM vehicles
JOIN inventory ON vehicles.vehicle_id = inventory.vehicle_id
JOIN dealerships ON dealerships.dealership_id = inventory.dealership_id
WHERE vin = '1HGCM82633A123458';

SELECT dealerships.name, dealerships.address
FROM vehicles
JOIN inventory ON vehicles.vehicle_id = inventory.vehicle_id
JOIN dealerships ON dealerships.dealership_id = inventory.dealership_id
WHERE make = 'Toyota' AND model = 'Camry';


