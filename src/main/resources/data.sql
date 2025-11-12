INSERT INTO tags (id, asset_name, location, last_seen, status)
VALUES
    ('TAG001', 'Laptop A', 'Warehouse A', NOW(), 'active'),
    ('TAG002', 'Monitor B', 'Dock B', NOW(), 'inactive'),
    ('TAG003', 'Printer C', 'Zone C', NOW(), 'active');
INSERT INTO tag_scan_log (tag_id, location, timestamp)
VALUES
    ('TAG001', 'Warehouse A', NOW()),
    ('TAG002', 'Dock B', NOW());
