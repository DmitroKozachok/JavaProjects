# Stage 1: Build stage
FROM mcr.microsoft.com/dotnet/sdk:10.0 AS build
WORKDIR /source

# Копіюємо проект і відновлюємо залежності
COPY ["TaskManagerAPI/TaskManagerAPI.csproj", "TaskManagerAPI/"]
RUN dotnet restore "TaskManagerAPI/TaskManagerAPI.csproj"

# Копіюємо всі файли і будуємо додаток
COPY . .
WORKDIR /source/TaskManagerAPI
RUN dotnet publish -c Release -o /app

# Stage 2: Final image for runtime
FROM mcr.microsoft.com/dotnet/aspnet:10.0

WORKDIR /app

# Копіюємо додаток з етапу побудови
COPY --from=build /app .

# HTTPS
ENV ASPNETCORE_URLS=https://0.0.0.0:8080
ENV ASPNETCORE_Kestrel__Certificates__Default__Path=/https/cert.pfx

# Запускаємо додаток
ENTRYPOINT ["dotnet", "TaskManagerAPI.dll"]
