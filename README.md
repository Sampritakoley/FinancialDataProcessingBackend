Finance Data Processing Backend API Documentation

Backend service built using Spring Boot with role-based access control using Spring Security and authentication via JSON Web Token.
Data persistence is handled using MySQL.


Authentication

Authentication is handled using JWT tokens.

After login, include the token in the header:

Authorization: Bearer <JWT_TOKEN>
User Roles
Role	Permissions
VIEWER	View dashboard summaries
ANALYST	View financial records and analytics
ADMIN	Full access (manage users and records)
API Endpoints
1 Authentication APIs
Register User

Creates a new user account.

POST /api/auth/register
Request Body
{
  "name": "Samprita",
  "email": "samprita@gmail.com",
  "password": "password123",
  "role": "ANALYST"
}
Response
{
  "message": "User registered successfully"
}
Login

Authenticate user and return JWT token.

POST /api/auth/login
Request
{
  "email": "samprita@gmail.com",
  "password": "password123"
}
Response
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
2 User Management APIs

(Accessible only by ADMIN)

Get All Users
GET /api/users
Response
[
  {
    "id": 1,
    "name": "Samprita",
    "email": "samprita@gmail.com",
    "role": "ADMIN",
    "active": true
  }
]
Update User
PUT /api/users/{id}
Request
{
  "name": "Samprita Koley",
  "role": "ANALYST"
}
Deactivate User
DELETE /api/users/{id}
Response
User deactivated successfully
3 Financial Records APIs

Accessible by ADMIN and ANALYST

Create Financial Record
POST /api/records
Request
{
  "amount": 5000,
  "type": "income",
  "category": "salary",
  "date": "2026-04-01",
  "notes": "Monthly salary"
}
Response
{
  "id": 1,
  "amount": 5000,
  "type": "income",
  "category": "salary",
  "date": "2026-04-01",
  "notes": "Monthly salary"
}
Get All Records
GET /api/records
Response
[
  {
    "id": 1,
    "amount": 5000,
    "type": "income",
    "category": "salary",
    "date": "2026-04-01"
  }
]
Get Record By ID
GET /api/records/{id}
Update Record
PUT /api/records/{id}
Request
{
  "amount": 4500,
  "category": "salary"
}
Delete Record
DELETE /api/records/{id}
Response
Record deleted successfully
4 Filtering Financial Records

Records can be filtered using query parameters.

GET /api/records?type=expense
GET /api/records?category=food
GET /api/records?startDate=2026-01-01&endDate=2026-04-01
5 Dashboard Summary APIs

Accessible by VIEWER, ANALYST, and ADMIN.

Get Financial Summary
GET /api/dashboard/summary
Response
{
  "totalIncome": 12000,
  "totalExpense": 8000,
  "netBalance": 4000
}
Category Wise Summary
GET /api/dashboard/category-summary
Response
[
  {
    "category": "Food",
    "total": 500
  },
  {
    "category": "Travel",
    "total": 300
  }
]
Monthly Financial Trend
GET /api/dashboard/monthly-trends
Response
[
  {
    "month": "January",
    "income": 5000,
    "expense": 2000
  },
  {
    "month": "February",
    "income": 4000,
    "expense": 2500
  }
]
Error Handling

The API returns standard HTTP status codes.

Code	Meaning
200	Success
400	Bad Request
401	Unauthorized
403	Forbidden
404	Not Found
500	Internal Server Error
Example Error Response
{
  "timestamp": "2026-04-06T10:30:00",
  "status": 400,
  "error": "Invalid request",
  "message": "Amount must be greater than zero"
}
Pagination (Optional Feature)
GET /api/records?page=0&size=10
API Documentation (Swagger)

Interactive API documentation is available via:

http://localhost:8080/swagger-ui.html

Provided using Swagger.

