namespace TaskMangerAPI.Interfaces;

public interface IIdentityService
{
    Task<long> GetUserIdAsync();
}
