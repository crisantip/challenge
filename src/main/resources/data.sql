-- DEVICE
insert into DEVICE (device_id, type, system_name)
values (1, 'Windows', 'PC01');

insert into DEVICE (device_id, type, system_name)
values (2, 'Mac', 'PC02');

insert into DEVICE (device_id, type, system_name)
values (3, 'Linux', 'PC03');

-- SERVICE
insert into SERVICE (service_id, name)
values (1, 'Device');

insert into SERVICE (service_id, name)
values (2, 'Antivirus');

insert into SERVICE (service_id, name)
values (3, 'Backup');

insert into SERVICE (service_id, name)
values (4, 'Screen Share');

-- DEVICE_SERVICE
insert into DEVICE_SERVICE (device_service_id, device_id, service_id, cost, status)
values (1, 1, 1, 4, 1);

insert into DEVICE_SERVICE (device_service_id, device_id, service_id, cost, status)
values (2, 2, 1, 4, 1);

insert into DEVICE_SERVICE (device_service_id, device_id, service_id, cost, status)
values (3, 1, 2, 5, 1);

insert into DEVICE_SERVICE (device_service_id, device_id, service_id, cost, status)
values (4, 2, 2, 7, 1);

insert into DEVICE_SERVICE (device_service_id, device_id, service_id, cost, status)
values (5, 1, 3, 3, 1);

insert into DEVICE_SERVICE (device_service_id, device_id, service_id, cost, status)
values (6, 2, 3, 3, 1);

insert into DEVICE_SERVICE (device_service_id, device_id, service_id, cost, status)
values (7, 1, 4, 1, 1);

insert into DEVICE_SERVICE (device_service_id, device_id, service_id, cost, status)
values (8, 2, 4, 1, 1);

-- INVOICE
insert into INVOICE (invoice_id, customer_id, customer_name, date)
values (1, '123', 'Christian Inapanta', '2022-11-09');

-- INVOICE DETAIL
insert into INVOICE_DETAIL (invoice_detail_id, invoice_id, device_service_id, quantity)
values (1, 1, 1, 2);

insert into INVOICE_DETAIL (invoice_detail_id, invoice_id, device_service_id, quantity)
values (2, 1, 2, 3);

insert into INVOICE_DETAIL (invoice_detail_id, invoice_id, device_service_id, quantity)
values (3, 1, 3, 2);

insert into INVOICE_DETAIL (invoice_detail_id, invoice_id, device_service_id, quantity)
values (4, 1, 4, 3);

insert into INVOICE_DETAIL (invoice_detail_id, invoice_id, device_service_id, quantity)
values (5, 1, 5, 1);

insert into INVOICE_DETAIL (invoice_detail_id, invoice_id, device_service_id, quantity)
values (6, 1, 6, 2);

insert into INVOICE_DETAIL (invoice_detail_id, invoice_id, device_service_id, quantity)
values (7, 1, 7, 2);

insert into INVOICE_DETAIL (invoice_detail_id, invoice_id, device_service_id, quantity)
values (8, 1, 8, 2);