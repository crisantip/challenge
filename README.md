# NinjaOne Backend Interview Project Solution

This project contains the technical challenge solution.

For manual integration test you can use the 
[Postman collection](RMM.postman_collection.json)


## Starting the Application

Run the `BackendInterviewProjectApplication` class

## Device Endpoints

---
**Funcionality:** Create a device

**Method:** POST

**URL:** http://localhost:8080/devices

**Body example:**

```json
{
  "type": "windows",
  "systemName": "pc0158"
}
```
---
**Funcionality:** Delete a device

**Method:** DELETE

**URL:** http://localhost:8080/devices/{deviceId}

**Example:**

```json
http://localhost:8080/devices/4
```


## Service Endpoints

---
**Funcionality:** Create a service

**Method:** POST

**URL:** http://localhost:8080/services

**Body example:**

```json
{
  "name": "Office"
}
```
---
**Funcionality:** Delete a service

**Method:** DELETE

**URL:** http://localhost:8080/services/{serviceId}

**Example:**

```json
http://localhost:8080/services/5
```

## Association Device and Service Endpoints

---
**Funcionality:** Create an association 

**Method:** POST

**URL:** http://localhost:8080/device-services

**Body example:**

```json
{
  "device": {
    "id": 1
  },
  "service": {
    "id": 4
  },
  "cost": 7
}
```
---
**Funcionality:** Delete an association

**Method:** DELETE

**URL:** http://localhost:8080/device-services/{deviceServiceId}

**Example:**

```json
http://localhost:8080/device-services/9
```

## Invoice Endpoint

---
**Funcionality:** Calculate the total cost of the services and devices

**Method:** GET

**URL:** http://localhost:8080/invoices/{customerId}

**Example:**

```json
http://localhost:8080/invoices/123
```
**Response example:**

```json
{
  "customerId": "123",
  "services": {
    "1": {
      "id": 1,
      "name": "Device",
      "totalServiceCost": 20.0,
      "devices": [
        {
          "id": 1,
          "type": "Windows",
          "systemName": "PC01",
          "quantity": 2,
          "cost": 4.0,
          "totalDeviceCost": 8.0
        },
        {
          "id": 2,
          "type": "Mac",
          "systemName": "PC02",
          "quantity": 3,
          "cost": 4.0,
          "totalDeviceCost": 12.0
        }
      ]
    },
    "2": {
      "id": 2,
      "name": "Antivirus",
      "totalServiceCost": 31.0,
      "devices": [
        {
          "id": 1,
          "type": "Windows",
          "systemName": "PC01",
          "quantity": 2,
          "cost": 5.0,
          "totalDeviceCost": 10.0
        },
        {
          "id": 2,
          "type": "Mac",
          "systemName": "PC02",
          "quantity": 3,
          "cost": 7.0,
          "totalDeviceCost": 21.0
        }
      ]
    },
    "3": {
      "id": 3,
      "name": "Backup",
      "totalServiceCost": 9.0,
      "devices": [
        {
          "id": 1,
          "type": "Windows",
          "systemName": "PC01",
          "quantity": 1,
          "cost": 3.0,
          "totalDeviceCost": 3.0
        },
        {
          "id": 2,
          "type": "Mac",
          "systemName": "PC02",
          "quantity": 2,
          "cost": 3.0,
          "totalDeviceCost": 6.0
        }
      ]
    },
    "4": {
      "id": 4,
      "name": "Screen Share",
      "totalServiceCost": 4.0,
      "devices": [
        {
          "id": 1,
          "type": "Windows",
          "systemName": "PC01",
          "quantity": 2,
          "cost": 1.0,
          "totalDeviceCost": 2.0
        },
        {
          "id": 2,
          "type": "Mac",
          "systemName": "PC02",
          "quantity": 2,
          "cost": 1.0,
          "totalDeviceCost": 2.0
        }
      ]
    }
  },
  "totalInvoiceCost": 64.0
}
```