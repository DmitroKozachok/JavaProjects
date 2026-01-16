using TaskMangerAPI.Entities.Identity;

namespace TaskMangerAPI.Interfaces;

public interface IJWTTokenService
{
    Task<string> CreateTokenAsync(UserEntity user);
}
