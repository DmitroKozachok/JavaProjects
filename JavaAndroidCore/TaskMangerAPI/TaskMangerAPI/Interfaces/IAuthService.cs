using TaskMangerAPI.Models.Auth;

namespace TaskMangerAPI.Interfaces;

public interface IAuthService
{
    public Task<string> LoginAsync(LoginModel model);
    public Task<string> RegisterAsync(RegisterModel model);
}
